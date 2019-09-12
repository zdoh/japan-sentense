import React from 'react';
import Row from "react-bootstrap/Row";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";

const button = (props) => {
  let buttonElement = null;

  switch (props.elementType) {

    case ("submitButton"):
      buttonElement = (
        <Form.Group as={Row}>
          <Col sm={{span: 10, offset: 2}}>
            <Button type="submit">{props.buttonName}</Button>
          </Col>
        </Form.Group>
      );

      break;
    default:
      buttonElement = (
        <Form.Group as={Row}>
          <Col sm={{span: 10, offset: 2}}>
            <Button type="button">{props.buttonName}</Button>
          </Col>
        </Form.Group>
      );


  }

  return (
    <div>
      {buttonElement}
    </div>

  )
};


export default button;