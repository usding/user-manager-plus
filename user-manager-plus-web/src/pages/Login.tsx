import React, { ReactElement } from 'react'
import { Form, Input, Button } from 'antd'
import { history, connect } from 'umi'
import HouseImg from '@/images/login_background.jpg'
import axios from '@/util/Axios'
class Login extends React.Component<any, any> {
    layout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 15 }
    }

    tailLayout = {
      wrapperCol: { offset: 10, span: 12 }
    }

    componentDidMount (): void{
      this.props.dispatch({
        type: 'ALL/refresh'
      })
    }

    render (): ReactElement {
      return (
        <React.Fragment>
          <div
            style={{
              width: '100vw',
              height: '100vh',
              backgroundImage: `url(${HouseImg})`,
              backgroundSize: 'cover'
            }}
          >
            <div
              style={{
                width: '100%',
                paddingTop: '10%',
                paddingLeft: '30%'
              }}
            >
              <Form
                {...this.layout}
                style={{
                  width: '40%',
                  backgroundColor: 'rgba(255,255,255,1)',
                  paddingTop: '2rem',
                  paddingBottom: '1rem',
                  borderRadius: '5px',
                  boxShadow: '0 0 4px 2px rgb(176,190,197, 0.6)'
                }}
                onFinish={(values: any): void => {
                  axios.get('/login', {
                    params: {
                      loginName: values.username,
                      password: values.password
                    }
                  }).then(({ data }) => {
                    if (data.success) {
                      this.props.dispatch({
                        type: 'ALL/save',
                        payload: {
                          user: data.data
                        }
                      })
                      history.push('/')
                    }
                  })
                }}
              >
                <Form.Item
                  label="用户名"
                  name="username"
                  rules={[{ required: true, message: '请输入用户名!' }]}
                >
                  <Input />
                </Form.Item>

                <Form.Item
                  label="密码"
                  name="password"
                  rules={[{ required: true, message: '请输入密码!' }, { min: 6, message: '密码长度小于6' }]}
                >
                  <Input.Password />
                </Form.Item>
                <Form.Item {...this.tailLayout}>
                  <Button type="primary" htmlType="submit">
                                    登录
                  </Button>
                </Form.Item>
              </Form>
            </div>
          </div>

        </React.Fragment>
      )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(Login)
