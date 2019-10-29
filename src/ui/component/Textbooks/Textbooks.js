import React, {Component} from 'react';
import {connect} from "react-redux";
import axios from 'axios';
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import {LinkContainer} from 'react-router-bootstrap';
import InProgress from "../InProgress/InProgress";

class Textbooks extends Component {

  state = {
    textbooksSample: []
  };

  componentDidMount() {
    this.getTextbook()
  }

  getTextbook() {
    axios.get('/textbook/simple', {headers: {Authorization: 'Bearer ' + this.props.token}})
      .then(response => {
        this.setState({
          textbooksSample: response.data
        });

      }).catch(error => {
      console.log(error);
    });
  }


  render() {
    const textbooks = this.state.textbooksSample.map(textbook => {
        return (
          <React.Fragment key={textbook.id}>
            <tr className="d-flex">
              <td className="col-5">{textbook.japaneseName}</td>
              <td className="col-5">{textbook.englishName}</td>
              <td className="col-2">
                <LinkContainer to={`/textbook/${textbook.id}`}>
                  <Button variant="primary">Просмотр</Button>
                </LinkContainer>
              </td>
            </tr>
          </React.Fragment>
        )
    });

    return (
      <div className="container-fluid">
        <InProgress mes="Добавление новых учебников и глав в учебники находится в разработке"/>
        <Table striped bordered hover responsive="md" size="sm">
          <thead>
          <tr className="d-flex">
            <th className="col-5">Название на японском</th>
            <th className="col-5">Английское название</th>
            <th className="col-2">Просмотр</th>
          </tr>
          </thead>
          <tbody>
          {textbooks}
          </tbody>
        </Table>
      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    token: state.token
  }
};

export default connect(mapStateToProps)(Textbooks);