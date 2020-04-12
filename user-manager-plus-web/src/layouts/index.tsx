import React, { ReactElement } from 'react'
import Head from '@/layouts/Head'
import { history, connect } from 'umi'
import axios from '@/util/Axios'

class Layout extends React.Component<any, any> {
  state: any
  constructor (props: any) {
    super(props)
    this.state = {
      collapsed: false,
      user: null
    }
  }

  UNSAFE_componentWillMount (): void {
    axios.get('/checkLogin').then(({ data }) => {
      if (data.success) {
        const user = data.data
        if (!user.id) {
          history.push('/toLogin')
          return
        }
        this.props.dispatch({
          type: 'ALL/save',
          payload: {
            user: user
          }
        })
        this.setState({
          user: user
        })
      } else {
        history.push('/toLogin')
      }
    })
  }

  componentDidMount (): void{
    this.props.dispatch({
      type: 'ALL/save',
      payload: {
        selKeys: ['2.1']
      }
    })
    history.push('/students')
  }

  render (): ReactElement | null {
    if (!this.props.ALL.user) {
      return null
    }

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

    )
  }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(Layout)
