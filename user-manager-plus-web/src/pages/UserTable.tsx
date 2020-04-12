import React, { ReactElement } from 'react'
import zhCN from 'antd/es/locale/zh_CN'
import { ConfigProvider, Button, Table, Modal, Form, Input, Select, message } from 'antd'
import { history, connect } from 'umi'
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'
import axios from '@/util/Axios'

class UserTable extends React.Component<any, any> {
  state: any
  layout = {
    labelCol: { span: 4 },
    wrapperCol: { span: 20 }
  }

  tailLayout = {
    wrapperCol: { offset: 10, span: 14 }
  }

  columns = [{
    title: '用户名',
    dataIndex: 'userName',
    key: 'userName'
  }, {
    title: '角色',
    dataIndex: 'role',
    key: 'role',
    render: (text: any): string => {
      if (text === 0) {
        return '管理员'
      } else {
        return '普通用户'
      }
    }
  }, {
    title: '注册时间',
    dataIndex: 'registerDate',
    key: 'registerDate',
    render: (date: string): string => {
      return (new Date(date).toLocaleDateString())
    }
  }, {
    title: '用户状态',
    dataIndex: 'state',
    key: 'state',
    render: (state: string): string => {
      return state === 'A' ? '正常' : '禁用'
    }
  }, {
    title: '操作',
    dataIdnex: 'operation',
    key: 'operation',
    render: (text: any, record: any): ReactElement => {
      return (
        <React.Fragment>
          <Button
            type='primary'
            size='small'
            icon={<EditOutlined />}
            shape='circle'
            onClick={(): void => {
              this.setState({
                editModal: true,
                editUser: record
              })
              if (this.formRef.current) {
                this.formRef.current.setFieldsValue({
                  userName: record.userName,
                  role: record.role.toString(),
                  state: record.state
                })
              }
            }}
          >

          </Button>
          <Button
            type='danger'
            size='small'
            icon={<DeleteOutlined />}
            shape='circle'
            style={{
              marginLeft: '0.5rem'
            }}
            onClick={(): void => {
              if (this.props.ALL?.user?.id === record.id) {
                message.error('不能删除登录用户')
                return
              }
              this.setState({
                userToDel: Object.assign({}, record),
                delModal: true
              })
            }}
          ></Button>
        </React.Fragment>
      )
    }
  }]

  pagination = {
    pageSize: 10
  }

  formRef: any = React.createRef()
  constructor (props: any) {
    super(props)
    this.state = {
      users: [],
      editModal: false,
      editUser: null,
      userToDel: null,
      delModal: false
    }
  }

  async getUserList (): Promise<void> {
    axios.get('/user/userList').then((response) => {
      console.dir(response)
      if (!response) {
        return
      }
      const data = response.data
      if (data?.data && data.data.length > 0) {
        data.data.forEach((val: any) => {
          val.key = val.id
          val.operation = null
        })
        this.setState({
          users: data.data
        })
      }
    })
  }

  componentDidMount (): void {
    this.getUserList()
  }

  renderEditUserModal (): ReactElement {
    return (
      <React.Fragment>
        <Modal
          title='编辑用户'
          visible={this.state.editModal}
          onCancel={(): void => { this.setState({ editModal: false }) }}
          footer={null}
        >
          <Form
            ref={this.formRef}
            {...this.layout}
            initialValues={this.state.editUser ? {
              userName: this.state.editUser.userName,
              role: this.state.editUser.role.toString(),
              state: this.state.editUser.state
            } : {}}

            onFinish={async (values: any) => {
              const user = {
                id: this.state.editUser.id,
                userName: values.userName,
                role: parseInt(values.role),
                state: values.state,
                password: this.state.editUser.password
              }
              axios.post('/user/editUser', user).then(({ data }) => {
                if (data.success) {
                  this.setState({ editModal: false })
                  message.success('编辑成功')
                  this.getUserList()
                }
              })
            }}
          >
            <Form.Item
              label='用户名'
              name='userName'
              rules={[{ required: true, message: '请输入用户名' }]}
            >
              <Input />
            </Form.Item>
            {/* <Form.Item
                            label='密码'
                            name='password'
                            rules={[{ required: true, message: '请输入密码' }]}
                        >
                            <Input.Password />
                        </Form.Item> */}
            {/* <Form.Item
                        label='手机号'
                        name='tel'
                    >
                        <Input />
                    </Form.Item> */}
            <Form.Item
              label='用户角色'
              name='role'
              rules={[{ required: true, message: '请选择用户角色' }]}
            >
              <Select>
                <Select.Option value='0'>管理员</Select.Option>
                <Select.Option value='1'>普通用户</Select.Option>
              </Select>
            </Form.Item>
            <Form.Item
              label='用户状态'
              name='state'
              rules={[{ required: true, message: '请选择用户状态' }]}
            >
              <Select>
                <Select.Option value='A'>启用</Select.Option>
                <Select.Option value='X'>禁用</Select.Option>
              </Select>
            </Form.Item>
            <Form.Item {...this.tailLayout}>
              <Button type="primary" htmlType="submit">
                确定
              </Button>
            </Form.Item>
          </Form>
        </Modal>
      </React.Fragment>
    )
  }

  renderDelModal (): ReactElement {
    return (
      <Modal title='删除用户'
        visible={this.state.delModal}
        onCancel={(): void => { this.setState({ delModal: false }) }}
        onOk={(): void => {
          axios.get('/user/deleteUser', {
            params: {
              id: this.state.userToDel.id
            }
          }).then(({ data }) => {
            if (data.success) {
              this.setState({ delModal: false })
              message.success('删除成功')
              this.getUserList()
            }
          })
        }}
      >
        <p>确定删除用户: {this.state.userToDel ? this.state.userToDel.userName : null}</p>
      </Modal>
    )
  }

  render (): ReactElement {
    return (
      <React.Fragment>
        <ConfigProvider locale={zhCN}>
          {this.renderEditUserModal()}
          {this.renderDelModal()}
        </ConfigProvider>

        <div
          style={{
            width: '100%'
          }}
        >
          {/* <Button type='primary'
                        onClick={(): void => {
                            history.push('/addUser')
                            this.props.dispatch({
                                type: 'ALL/save',
                                payload: {
                                    selKeys: ['1.2'],
                                    editUser: null
                                }
                            })
                        }}
                    >
                        添加用户
                    </Button> */}
        </div>
        <Table bordered size='middle' columns={this.columns} dataSource={this.state.users} pagination={this.pagination}></Table>
      </React.Fragment>
    )
  }
}
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(UserTable)
