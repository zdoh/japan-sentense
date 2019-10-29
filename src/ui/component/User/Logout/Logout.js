import React from "react";
import {connect} from "react-redux";
import Nav from "react-bootstrap/Nav";
import * as action from "../../../store/actions"

const logout = (props) => {
  return (
    <div>
      <Nav>
        <Nav.Link eventKey="login" onSelect={props.onLogout}>Выйти</Nav.Link>
      </Nav>
    </div>
  )
};

const mapDispatchToProps = dispatch => {
  return {
    onLogout: () => dispatch(action.logout())
  }
};

export default connect(null, mapDispatchToProps)(logout);