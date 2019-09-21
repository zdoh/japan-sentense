import React, {Component} from 'react';
import Nav from "react-bootstrap/Nav";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";

class Sigup extends Component {

  state = {
    show: false
  };

  closeHandler = () => {
    this.setState({
      show: false
    })
  };

  openHandler = () => {
    this.setState({
      show: true
    })
  };

  render() {
    return (
      <div>
        <Nav>
          <Nav.Link eventKey="login" onSelect={this.openHandler}>Регистрация</Nav.Link>
        </Nav>

        <Modal show={this.state.show} onHide={this.closeHandler}>
          <Modal.Header closeButton>
            <Modal.Title>Регистрация</Modal.Title>
          </Modal.Header>
          <Modal.Body>Раздел "Регистрация" находится в разработке</Modal.Body>
          <Modal.Footer>
            <Button variant="primary" onClick={this.closeHandler}>
              Ок
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    )
  }
}

export default Sigup;