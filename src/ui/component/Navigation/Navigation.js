import React, {Component} from 'react';
import {connect} from "react-redux";

import Navbar from "react-bootstrap/Navbar";
import {LinkContainer} from "react-router-bootstrap";
import Nav from "react-bootstrap/Nav";
import NavLinkCont from "../../hoc/NavLinkCont";
import NavDropdown from "react-bootstrap/NavDropdown";
import NavDropdownItemCont from "../../hoc/NavDropdownItemCont";
import Login from "../User/Login/Login";
import Sigup from "../User/Sigup/Sigup";
import WrongAuth from "../User/WrongAuth/WrongAuth";
import Logout from "../User/Logout/Logout";

class Navigation extends Component {

  render() {

    let userPart = null;

    if (this.props.isUser) {
      userPart = (
        <div>
          <Nav className="mr-auto">
            <NavLinkCont to="/study/sentence" name="Предложения"/>
            <NavLinkCont to="/study/word" name="Слова"/>
            <NavLinkCont to="/study/kanji" name="Кандзи"/>
          </Nav>
        </div>
      )
    }

    if (this.props.isAdmin) {
      userPart = (
        <div>
          <Nav className="mr-auto">
            <NavLinkCont to="/study/sentence" name="Предложения"/>
            <NavLinkCont to="/study/word" name="Слова"/>
            <NavLinkCont to="/study/kanji" name="Кандзи"/>
            <NavDropdown title="Управление" id="basic-nav-dropdown">
              <NavDropdownItemCont to="/textbooks" name="Учебники"/>
              {/*<NavDropdownItemCont to="/kanjis" name="Кандзи"/>*/}
              {/*<NavDropdownItemCont to="/words" name="Слова"/>*/}
              {/*<NavDropdownItemCont to="/grammars" name="Грамматика"/>*/}
              <NavDropdownItemCont to="/sentences" name="Предложение"/>
            </NavDropdown>
          </Nav>
        </div>
      )
    }

    let loginPart = (
      <Nav className="ml-auto" pullright>
        <Nav.Item href="#"><Sigup/></Nav.Item>
        <Nav.Item href="#"><Login/></Nav.Item>
        <WrongAuth/>
      </Nav>
    );

    if (this.props.isUser || this.props.isAdmin) {
      loginPart = (
        <Nav className="ml-auto" pullright>
          <Nav.Link disable>Вы залогинены как - {this.props.username}</Nav.Link>
          <Nav.Item href="#"><Logout/></Nav.Item>
          <WrongAuth/>
        </Nav>
      );
    }


    return (
      <div style={{marginBottom: "20px"}}>
        <Navbar bg="primary" expand="lg" variant="dark">
          <LinkContainer to="/">
            <Navbar.Brand>ПереведиКа</Navbar.Brand>
          </LinkContainer>
          <Navbar.Toggle aria-controls="basic-navbar-nav"/>
          <Navbar.Collapse id="basic-navbar-nav">
            {userPart}
            {loginPart}
          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    isUser: state.role === 'USER',
    isAdmin: state.role === 'ADMIN',
    username: state.username
  }
};


export default connect(mapStateToProps, null)(Navigation);