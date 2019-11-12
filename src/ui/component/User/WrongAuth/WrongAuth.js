import React, {Component} from 'react';
import Nav from "react-bootstrap/Nav";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Input from "../../Input/Input";
import {connect} from "react-redux";
import * as action from "../../../store/actions";

class WrongAuth extends Component {
  state = {
    show: false
  };

  okHandler = () => {
    this.setState({
      show: false
    });

    this.props.onAuthStart();
  };

  showHandler() {
    this.setState({show: true})
  };

  render() {
    if (this.props.error !== null && this.state.show === false) {
      this.showHandler();
    }

    return (

      <div>
        <Modal show={this.state.show} onHide={this.okHandler}>
          <Modal.Header closeButton>
            <Modal.Title>Ошибка авторизации</Modal.Title>
          </Modal.Header>
          <Modal.Body>Не правильные данные для авторизации</Modal.Body>
          <Modal.Footer>
            <Button variant="primary" onClick={this.okHandler}>
              Ок
            </Button>
          </Modal.Footer>
        </Modal>

      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    error: state.error
  }
};

const mapDispatchToProps = dispatch => {
  return {
    onAuthStart: () => dispatch(action.authStart())
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(WrongAuth);