import React, {Component} from 'react';
import Nav from "react-bootstrap/Nav";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Input from "../../Input/Input";
import {connect} from "react-redux";
import * as action from "../../../store/actions";

class Login extends Component {
  state = {
    login: '',
    pass: '',
    show: false
  };

  inputLoginHandler = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    })
  };

  closeHandler = () => {
    this.setState({
      show: false
    })
  };

  okHandler = () => {
    this.setState({
      show: false
    });

    this.props.onAuth(this.state.login, this.state.pass);
  };

  openHandler = () => {
    this.setState({
      show: true
    })
  };


  render() {
    const {login, pass} = {...this.state};

    //console.log(login + " " + pass);
    /*const form = (
      <Form onSubmit={this.clickButtonHandler}>
        <Input elementType="input" labelSize="1" colSize="4" label="Логин:" placeholder="Введите логин" name="login"
               value={login} change={this.inputLoginHandler} classNames="justify-content-md-center"/>

        <Input elementType="password" labelSize="1" colSize="4" label="Пароль:" placeholder="Введите пароль" name="pass"
               value={pass} change={this.inputLoginHandler} classNames="justify-content-md-center"/>

        <Form.Group controlId="formBasicCheckbox">
          <Form.Check type="checkbox" label="Check me out"/>
        </Form.Group>

        <Button elementType="submitButton" buttonName="Войти"/>
      </Form>


    );*/

    return (

      <div>
        <Nav>
          <Nav.Link eventKey="login" onSelect={this.openHandler}>Войти</Nav.Link>
        </Nav>

        <Modal show={this.state.show} onHide={this.closeHandler}>
          <Modal.Header closeButton>
            <Modal.Title>Авторизация</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form>
              <Input elementType="input2" label="Логин:" placeholder="Введите логин" name="login"
                     value={login} change={this.inputLoginHandler}/>

              <Input elementType="password" label="Пароль:" placeholder="Введите пароль" name="pass"
                     value={pass} change={this.inputLoginHandler}/>

              <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Запомнить меня"/>
              </Form.Group>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={this.closeHandler}>
              Закрыть
            </Button>
            <Button variant="primary" onClick={this.okHandler}>
              Войти
            </Button>
          </Modal.Footer>
        </Modal>

      </div>
    )
  }
}

const mapDispatchToProps = dispatch => {
  return {
    onAuth: (username, password) => dispatch(action.auth(username, password)),
  }
};

export default connect(null, mapDispatchToProps)(Login);