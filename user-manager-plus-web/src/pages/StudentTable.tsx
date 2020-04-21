import React, { ReactElement } from 'react'
import zhCN from 'antd/es/locale/zh_CN'
import { ConfigProvider, Button, Table, Modal, Row, Input, Col, message, Tooltip, Form, Select } from 'antd'
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'
import { history, connect } from 'umi'
import axios from '@/util/Axios'

class StudentTable extends React.Component<any, any> {
    state: any
    searchFormRef: any = React.createRef()

    columns = [{
      title: '学员名',
      dataIndex: 'userName',
      key: 'userName',
      width: 100
    }, {
      title: '所属用户',
      dataIndex: 'belongName',
      key: 'belongName',
      width: 100
    }, {
      title: '批次',
      dataIndex: 'batch',
      key: 'batch',
      width: 200,
      render: (id: number): string|null => {
        if (this.props.ALL.batchList) {
          for (const batch of this.props.ALL.batchList) {
            if (batch.id === id) {
              return batch.name
            }
          }
        }
        return null
      }
    }, {
      title: '性别',
      dataIndex: 'userSex',
      key: 'userSex',
      width: 60,
      render: (text: string): string|null => {
        if (text === 'm') {
          return '男'
        } else if (text === 'f') {
          return '女'
        }
        return null
      }
    }, {
      title: '本地房产',
      dataIndex: 'localEstate',
      key: 'localEstate',
      width: 80,
      render: (text: string): string|null => {
        if (text === 'y') {
          return '有'
        } else if (text === 'n') {
          return '无'
        }
        return null
      }
    }, {
      title: '婚姻',
      dataIndex: 'maritalStatus',
      key: 'maritalStatus',
      width: 50,
      render: (text: string): string|null => {
        if (text === 'y') {
          return '已婚'
        } else if (text === 'n') {
          return '未婚'
        }
        return null
      }
    }, {
      title: '电话',
      dataIndex: 'phoneNumber',
      key: 'phoneNumber'
    }, {
      title: '微信',
      dataIndex: 'wechat',
      key: 'wechat'
    },
    {
      title: '定金',
      dataIndex: 'deposit',
      key: 'deposit'
    }, {
      title: '余额',
      dataIndex: 'finalPayment',
      key: 'finalPayment'
    }, {
      title: '总费用',
      dataIndex: 'totalCost',
      key: 'totalCost'
    }, {
      title: '操作',
      dataIndex: 'operation',
      key: 'operation',
      width: 120,
      render: (text: any, record: any): ReactElement => {
        return (
          <React.Fragment>
            {/* <Button
                        type='primary'
                        size='small'
                        icon={<InfoCircleOutlined />}
                        shape='circle'
                    ></Button> */}
            <Tooltip title='查看或编辑'>
              <Button
                type='primary'
                size='small'
                icon={<EditOutlined />}
                shape='circle'
                style={{
                  marginLeft: '0.5rem'
                }}
                onClick={(): void => {
                  this.props.dispatch({
                    type: 'ALL/save',
                    payload: {
                      editStudent: record,
                      selKeys: ['2.3']
                    }
                  })
                  history.push('/editStudent')
                }}
              >
              </Button>
            </Tooltip>
            <Tooltip title='删除'>
              <Button
                type='danger'
                size='small'
                icon={<DeleteOutlined />}
                shape='circle'
                style={{
                  marginLeft: '0.5rem'
                }}
                onClick={(): void => {
                  this.setState({
                    deleteModal: true,
                    studentToDel: record
                  })
                }}
              ></Button>
            </Tooltip>
          </React.Fragment>
        )
      }
    }]

    constructor (props: any) {
      super(props)
      this.state = {
        users: [],
        studentList: [],
        searchList: [],
        deleteModal: false,
        studentToDel: null,
        total: 0,
        pageNum: 1,
        pageSize: 10,
        search: false,
        pagination: {
          pageSize: 10,
          total: 10,
          showTotal: (): string => `共${this.state.total}条`,
          onChange: (current: number): void => {
            this.setState({
              pageNum: current
            }, () => {
              this.getStudentList()
            })
          }
        }
      }
    }

    getStudentList (): void {
      axios.get('/student/studentList', {
        params: {
          page: this.state.pageNum,
          size: this.state.pageSize
        }
      }).then(({ data }) => {
        if (data.success) {
          const list = data.data.rows
          list.forEach((val: any) => {
            val.key = val.id
            val.operation = null
          })
          // eslint-disable-next-line react/no-direct-mutation-state
          this.state.pagination.total = data.data.totalRows
          this.setState({
            search: false,
            studentList: data.data.rows,
            // pagination: Object.assign({}, this.state.pagination),
            total: data.data.totalRows
          })
        }
      })
    }

    getBatchList (): void{
      axios.get('/batch/batchList').then(({ data }) => {
        if (data.success) {
          console.dir(data.data)
          data.data.forEach((batch: any): void => {
            batch.key = batch.id
          })
          this.props.dispatch({
            type: 'ALL/save',
            payload: {
              batchList: data.data
            }
          })
        }
      })
    }

    getUserList (): void {
      axios.get('/user/userList').then((response) => {
        console.dir(response)
        if (!response) {
          return
        }
        const data = response.data
        if (data?.data && data.data.length > 0) {
          // data.data.forEach((val: any) => {
          // })
          this.setState({
            users: data.data
          })
        }
      })
    }

    componentDidMount (): void {
      this.getStudentList()
      this.getBatchList()
      this.getUserList()
    }

    renderDeleteModal (): ReactElement {
      return (
        <ConfigProvider locale={zhCN}>
          <Modal
            title='删除学员'
            visible={this.state.deleteModal}
            onCancel={(): void => { this.setState({ deleteModal: false }) }}
            width='40%'
            onOk={(): void => {
              axios.get('/student/deleteStudent', {
                params: {
                  id: this.state.studentToDel.id
                }
              }).then(({ data }) => {
                if (data.success) {
                  this.getStudentList()
                  message.success('删除成功')
                  this.setState({ deleteModal: false })
                }
              })
            }}
          >
            <p>确定删除学员: {this.state.studentToDel ? this.state.studentToDel.userName : null}?</p>
          </Modal>
        </ConfigProvider>

      )
    }

    renderBatchList (): ReactElement | ReactElement[] | null {
      if (!this.props?.ALL?.batchList) {
        return null
      }
      return this.props.ALL.batchList.map((val: any) => {
        return (
          <Select.Option key={val.id} value={val.id} >{val.name}</Select.Option>
        )
      })
    }

    renderUserSelect (): ReactElement | null {
      if (this.props.ALL.user.role === 0) {
        return (
          <Col span={5}>
            <Form.Item
              name='belong'
            >
              <Select
                style={{
                  width: '100%'
                }}
                showSearch
                placeholder='请选择一个用户'
                filterOption={(input, option): boolean => {
                  return option!.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                }
                }
              >
                {this.renderUserSelectOption()}
              </Select>
            </Form.Item>
          </Col>
        )
      }
      return null
    }

    renderUserSelectOption (): ReactElement[] | null {
      return this.state.users.map((user: any) => {
        return (
          <Select.Option key={user.id} value={user.id}>{user.userName}</Select.Option>
        )
      })
    }

    render (): ReactElement {
      return (
        <React.Fragment>
          {this.renderDeleteModal()}
          <Form
            ref={this.searchFormRef}
            onFinish={(values: any): void => {
              const student = {
                userName: values.userName,
                batch: parseInt(values.batch),
                belong: values.belong
              }
              axios.post('/student/searchStudent', student).then(({ data }) => {
                if (data.success) {}
                const list = data.data ? data.data : []
                list.forEach((val: any) => {
                  val.key = val.id
                  val.operation = null
                })
                this.setState({
                  search: true,
                  searchList: list
                })
              })
            }}
          >
            <Row
              gutter={{ xs: 8, sm: 16, md: 24 }}
            >
              <Col span={3}>
                <Form.Item
                  name='userName'
                >
                  <Input placeholder='学员名' />
                </Form.Item>
              </Col>
              <Col span={5}>
                <Form.Item
                  name='batch'
                >
                  <Select
                    style={{
                      width: '100%'
                    }}
                    showSearch
                    placeholder='请选择一个批次'
                    filterOption={(input, option): boolean => {
                      return option!.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                    }
                    }
                  >
                    {this.renderBatchList()}
                  </Select>
                </Form.Item>
              </Col>
              {this.renderUserSelect()}
              <Col span={2}>
                <Form.Item >
                  <Button type='primary' htmlType='submit'>搜索</Button>
                </Form.Item>
              </Col>
              <Col span={2}>
                <Button type='primary'
                  onClick={(): void => {
                    this.setState({
                      search: false
                    })
                    this.searchFormRef.current.resetFields()
                  }}
                >
                  清空
                </Button>
              </Col>
            </Row>

          </Form>
          <Table bordered size='middle' columns={this.columns} dataSource={this.state.searchList}
            style={{
              display: this.state.search ? 'block' : 'none'
            }}></Table>
          <Table bordered size='middle' columns={this.columns} dataSource={this.state.studentList} pagination={this.state.pagination}
            style={{
              display: this.state.search ? 'none' : 'block'
            }}
          ></Table>

        </React.Fragment>
      )
    }
}

// export default StudentTable
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(StudentTable)
