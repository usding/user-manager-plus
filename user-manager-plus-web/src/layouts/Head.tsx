import React, { ReactElement } from 'react'
import { Menu, Button, Dropdown, Modal, Form, Input, message } from 'antd'
import { history, connect } from 'umi'
import axios from '@/util/Axios'
import qs from 'qs'
import {
  DownOutlined
} from '@ant-design/icons'

class Head extends React.Component<any, any> {
    state: any
    layout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 20 }
    }

    buttonLyout = {
      wrapperCol: { offset: 10, span: 2 }
    }

    constructor (props: any) {
      super(props)
      this.state = {
        collapsed: false,
        changePasswordModal: false
      }
    }

    logout (): void {
      axios.get('/logout').then(({ data }) => {
        if (data.success) {
          this.props.dispatch({
            type: 'ALL/save',
            payload: {
              user: null
            }
          })
          history.push('/login')
        }
      })
    }

    renderChangePasswordModal (): ReactElement {
      return (
        <Modal
          title='更改密码'
          visible={this.state.changePasswordModal}
          footer={null}
          onCancel={(): void => {
            this.setState({
              changePasswordModal: false
            })
          }}
        >
          <Form
            {...this.layout}
            onFinish={(values: any): void => {
              axios.post('/user/changePassword', qs.stringify({
                oldPassword: values.currentPassword,
                newPassword: values.newPassword
              })).then(({ data }) => {
                if (data.success) {
                  message.success('更改密码成功，需要重新登录')
                  this.setState({
                    changePasswordModal: false
                  })
                  history.push('/login')
                }
              })
            }}
          >
            <Form.Item
              label='当前密码'
              name='currentPassword'
              rules={[{ required: true, message: '请输入当前密码' }]}
            >
              <Input.Password />
            </Form.Item>
            <Form.Item
              label='新密码'
              name='newPassword'
              rules={[{ required: true, message: '请输入新密码' }]}
            >
              <Input.Password />
            </Form.Item>
            <Form.Item {...this.buttonLyout}>
              <Button type="primary" htmlType="submit">
                确定
              </Button>
            </Form.Item>
          </Form>
        </Modal>
      )
    }

    render (): ReactElement {
      let userManage
      if (this.props.ALL.user && this.props.ALL.user.role === 0) {
        userManage = (
          <Menu.SubMenu
            key='sub1'
            title={
              <span>
                {/* <MailOutlined /> */}
                <span>用户信息管理</span>
              </span>
            }
          >
            <Menu.Item
              key="1.1"
              onClick={(): void => {
                // console.dir(this.props.history)
                history.push('/users')
              }}
            >
              {/* <PieChartOutlined /> */}
              <span>用户列表</span>
            </Menu.Item>
            <Menu.Item
              key="1.2"
              onClick={(): void => {
                history.push('/addUser')
              }}
            >
              {/* <PieChartOutlined /> */}
              <span>添加用户</span>
            </Menu.Item>
          </Menu.SubMenu>
        )
      }
      const menu = (
        <Menu>
          <Menu.Item>
            <a onClick={this.logout.bind(this)}>
              退出
            </a>
          </Menu.Item>
          <Menu.Item>
            <a onClick={(): void => { this.setState({ changePasswordModal: true }) }}>
              更改密码
            </a>
          </Menu.Item>
        </Menu>
      )
      return (
        <React.Fragment>
          {this.renderChangePasswordModal()}
          <div
            style={{
              position: 'absolute',
              top: 0,
              width: '100%',
              height: '3rem',
              backgroundColor: 'white',
              boxShadow: '0 0 5px 2px rgba(158,158,158, 0.3)',
              lineHeight: '3rem'
            }}
          >
            {/* <Button
                        size='large'
                        style={{
                            height: '100%',
                            border: 'none'
                        }}
                        onClick={(): void => {
                            this.setState({
                                collapsed: !this.state.collapsed
                            })
                        }}
                    >
                        {this.state.collapsed ?
                            <MenuUnfoldOutlined style={{
                                fontSize: '1.2rem'
                            }} /> :
                            <MenuFoldOutlined
                                style={{
                                    fontSize: '1.2rem'
                                }}
                            />
                        }

                    </Button> */}
            <Dropdown
              overlay={menu}
              trigger={['click']}
            >
              <a
                className="ant-dropdown-link"
                onClick={e => e.preventDefault()}
                style={{
                  float: 'right',
                  marginRight: '3rem',
                  fontSize: '1.2rem'
                }}
              >
                {this.props.ALL.user.userName} <DownOutlined />
              </a>
            </Dropdown>,
          </div>
          <Menu
            mode='inline'
            selectedKeys={this.props.ALL.selKeys}
            inlineCollapsed={this.state.collapsed}
            defaultOpenKeys={['sub2']}
            onClick={(params: any): void => {
              this.props.dispatch({
                type: 'ALL/save',
                payload: {
                  selKeys: [params.key]
                }
              })
            }}
            style={{
              width: 'fit-content',
              height: '100%'
            }}
          >
            {userManage}
            <Menu.SubMenu
              key='sub2'
              title={
                <span>
                  {/* <MailOutlined /> */}
                  <span>学员信息管理</span>
                </span>
              }
            >
              <Menu.Item
                key="2.1"
                onClick={(): void => {
                  history.push('/students')
                }}
              >
                {/* <DesktopOutlined /> */}
                <span>学员列表</span>
              </Menu.Item>
              <Menu.Item
                key="2.2"
                onClick={(): void => {
                  history.push('/addStudent')
                }}
              >
                {/* <PieChartOutlined /> */}
                <span>添加学员</span>
              </Menu.Item>
              <Menu.Item
                key="2.3"
                onClick={(): void => {
                  history.push('/editStudent')
                }}
              >
                {/* <PieChartOutlined /> */}
                <span>编辑学员</span>
              </Menu.Item>
            </Menu.SubMenu>
          </Menu>
        </React.Fragment>

      )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(Head)
