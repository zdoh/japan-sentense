import React, {Component} from 'react';
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import MySpin from '../../MySpin/MySpin';

class Quiz extends Component {

  state = {
    showAnswer: false
  };

  checkAnswerHandler = () => {
    this.setState({
      showAnswer: true
    });
  };

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps !== this.props) {
      this.setState({
        showAnswer: false
      })
    }

  }

  render() {
    let question = <MySpin />;

    if (this.props.question) {
      question = (
        <div>
          {this.props.question}
          <Button variant="primary" onClick={this.checkAnswerHandler}>Ответить</Button>
        </div>
      );
    }
    let answer = null;
    if (this.state.showAnswer && this.props.answer) {
      answer = (
        <div>
          <Row className="justify-content-md-center">
            {this.props.answer}
          </Row>
          <Button variant="danger" onClick={this.props.badAnswerButton}>Не правильно</Button>
          <Button variant="success" onClick={this.props.goodAnswerButton}>Правильно</Button>
        </div>
      )
    }


    return (
      <div>
        {question}
        {answer}
      </div>
    )
  }
}

export default Quiz;