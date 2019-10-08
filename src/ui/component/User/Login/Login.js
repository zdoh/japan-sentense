import React, {Component} from 'react';
import Nav from "react-bootstrap/Nav";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Input from "../../Input/Input";


class Login extends Component {

  state = {
    login: '',
    pass: '',
    show: false
  };

  inputLoginHandler = (event) => {
    console.log(this.state.login + " " + this.state.pass);

    this.setState({
      [event.target.name]: event.target.value
    })
  };

  clickButtonHandler = (event) => {
    event.preventDefault();

    this.props.history.push
    console.log("click");
  };

  closeHandler = () => {
    this.setState({
      show: false
    })
  };

  okHandler = () => {

  };

  openHandler = () => {
    this.setState({
      show: true
    })
  };



  render() {
    const {login, pass} = {...this.state};
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
                     value={login} change={this.inputLoginHandler} />

              <Input elementType="password" label="Пароль:" placeholder="Введите пароль" name="pass"
                     value={pass} change={this.inputLoginHandler} />

              <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Запомнить меня" />
              </Form.Group>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={this.closeHandler}>
              Закрыть
            </Button>
            <Button variant="primary" onClick={this.closeHandler}>
              Войти
            </Button>
          </Modal.Footer>
        </Modal>

      </div>
    )
  }
}

export default Login;