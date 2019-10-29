import * as actionTypes from "../actions/actionTypes";
import * as errorTypes from "../actions/errorTypes";

const initialState = {
  username: null,
  token: null,
  role: null,
  exp: null,
  error: null,
  loading: false
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.AUTH_START:
      return {
        ...state,
        error: null,
        loading: true
      };

    case actionTypes.AUTH_SUCCESS:
      return {
        ...state,
        username: action.username,
        exp: action.exp,
        error: null,
        loading: false,
        token: action.token,
        role: action.role
      };

    case actionTypes.AUTH_FAIL:

      return {
        ...state,
        error: action.error,
        loading: false
      };

    case actionTypes.AUTH_LOGOUT:
      return {
        ...state,
        role: null,
        token: null,
        nickname: null,
        exp: null
      };

    default:
      return state;
  }

};

export default reducer;