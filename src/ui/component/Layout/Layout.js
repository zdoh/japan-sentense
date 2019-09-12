import React, {Component} from 'react';

import Navigation from "../Navigation/Navigation";
import Container from "react-bootstrap/Container";


class Layout extends Component {

  render() {
    return (
      <React.Fragment>
        <Navigation/>
        <Container/>

        <main>
          {this.props.children}
        </main>
      </React.Fragment>

    )
  }
}

export default Layout;