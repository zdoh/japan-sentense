import React from 'react';
import {LinkContainer} from 'react-router-bootstrap';
import Nav from "react-bootstrap/Nav";

const navLinkCont = () => {
  return (props) =>{
    const {to, name} = {...props};
    return (
      <LinkContainer to={to}>
        <Nav.Link>{name}</Nav.Link>
      </LinkContainer>
    )
  }
};

export default navLinkCont()