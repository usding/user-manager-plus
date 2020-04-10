import React, { ReactElement } from 'react';
import styles from './index.less';
import { Router, Route } from 'react-router'
import { createBrowserHistory } from 'history'
import { Menu, Button } from 'antd'
import Head from '../layouts/Head'
import UserTable from './UserTable'


class Index extends React.Component<any, any> {
  render(): ReactElement {
    return (
      <h1>Hello World!</h1>
    );
  }
}

export default Index;