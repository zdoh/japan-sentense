import React from 'react';
import NavDropdown from "react-bootstrap/NavDropdown";
import {LinkContainer} from "react-router-bootstrap";

const navDropdownItemCont = () => {
  return (props) => {
    const {to, name} = {...props};
    return (
      <LinkContainer to={to}>
        <NavDropdown.Item>{name}</NavDropdown.Item>
      </LinkContainer>
    )
  }
};

export default navDropdownItemCont();