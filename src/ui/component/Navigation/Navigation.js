import React, {Component} from 'react';
import Navbar from "react-bootstrap/Navbar";
import {LinkContainer} from "react-router-bootstrap";
import Nav from "react-bootstrap/Nav";
import NavLinkCont from "../../hoc/NavLinkCont";
import NavDropdown from "react-bootstrap/NavDropdown";
import NavDropdownItemCont from "../../hoc/NavDropdownItemCont";

class Navigation extends Component {

  render() {
    return (
      <div style={{marginBottom: "20px"}}>
        <Navbar bg="primary" expand="lg" variant="dark">
          <LinkContainer to="/">
            <Navbar.Brand>Jap.S.Help</Navbar.Brand>
          </LinkContainer>
          <Navbar.Toggle aria-controls="basic-navbar-nav"/>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <NavLinkCont to="/study/sentence" name="Предложения" />
              <NavLinkCont to="/study/word" name="Слова" />
              <NavLinkCont to="/study/kanji" name="Кандзи" />
              <NavDropdown title="Просмотр" id="basic-nav-dropdown">
                <NavDropdownItemCont to="/textbooks" name="Учебник" />
                <NavDropdownItemCont to="/kanjis" name="Кандзи" />
                <NavDropdownItemCont to="/words" name="Слова" />
                <NavDropdownItemCont to="/grammars" name="Грамматика" />
                <NavDropdownItemCont to="/sentences" name="Предложение" />
              </NavDropdown>
            </Nav>
            <Nav className="mr-sm-2">
              <NavLinkCont to="/settings" name="Настройки" />
              <NavLinkCont to="/exit" name="Выйти" />
            </Nav>

          </Navbar.Collapse>
        </Navbar>
      </div>
    )
  }
}

export default Navigation;