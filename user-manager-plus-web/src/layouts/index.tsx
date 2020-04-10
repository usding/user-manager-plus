import React, { ReactElement } from 'react';
import Head from '@/layouts/Head'

class Layout extends React.Component<any, any> {
  state: any
  constructor(props: any) {
    super(props);
    this.state = {
      collapsed: false
    }
  }

  render(): ReactElement {
    return (
      <React.Fragment>
        
        <section
          style={{
            display: 'flex',
            width: '100%',
            height: '100vh',
            paddingTop: '3.3rem'
          }}
        >
          <Head />
          
          <div style={{
            width: '100%',
            height: '100%',
            padding: '1rem',
            overflowY: 'auto'
          }}>
            {this.props.children}
          </div>

        </section>

      </React.Fragment>

    );
  }
}

export default Layout;