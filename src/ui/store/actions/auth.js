import * as actionTypes from "./actionTypes";
import * as constants from "./constants";
import axios from "axios";
import * as errorTypes from "./errorTypes";

export const authStart = () => {
  return {
    type: actionTypes.AUTH_START,
  }
};

export const authFail = (error) => {
  let err = null;
  if (error.message === errorTypes.ERROR_401) {
    err = error.message;
  }

  return {
    type: actionTypes.AUTH_FAIL,
    error: err
  }
};

export const authSuccess = (data) => {
  let role = null;
  if (data.roles.includes('ROLE_USER')) role = 'USER';
  if (data.roles.includes('ROLE_ADMIN')) role = 'ADMIN';

  return {
    type: actionTypes.AUTH_SUCCESS,
    username: data.username,
    token: data.token,
    role: role,
    exp: data.exp
  }
};

export const checkAuthTimeout = (expireTime) => {
  return dispatch => {
    setTimeout(() => {
      dispatch(logout())
    }, expireTime);
  }
};

export const auth = (username, password) => {
  return dispatch => {
    dispatch(authStart);

    const url = "http://localhost:8080/login";
    axios.post(url, {
      username: username, password: password
    }).then(response => {
      console.log(response.data);
      localStorage.setItem(constants.TOKEN, response.data.token);
      localStorage.setItem(constants.EXPIRATION_DATE, response.data.exp);
      localStorage.setItem(constants.USERNAME, response.data.username);
      localStorage.setItem(constants.ROLES, response.data.roles);
      dispatch(authSuccess(response.data));
      dispatch(checkAuthTimeout(new Date(response.data.exp) - new Date()));
    }).catch(err => {
      dispatch(authFail(err))
    })

  }
};

export const authCheckState = () => {
  return dispatch => {
    const token = localStorage.getItem(constants.TOKEN);
    if (!token) {
      dispatch(logout());
    } else {
      const expirationDate = new Date(localStorage.getItem(constants.EXPIRATION_DATE));
      if (expirationDate <= new Date()) {
        dispatch(logout());
      } else {
        const username = localStorage.getItem(constants.USERNAME);
        const roles = localStorage.getItem(constants.ROLES);
        const data = {
          username: username,
          token: token,
          roles: roles,
          exp: expirationDate
        };
        dispatch(authSuccess(data));
        dispatch(checkAuthTimeout(expirationDate - new Date()));
      }
    }
  }
};


export const logout = () => {
  localStorage.removeItem(constants.TOKEN);
  localStorage.removeItem(constants.USERNAME);
  localStorage.removeItem(constants.ROLES);
  localStorage.removeItem(constants.EXPIRATION_DATE);
  return {
    type: actionTypes.AUTH_LOGOUT
  }
};