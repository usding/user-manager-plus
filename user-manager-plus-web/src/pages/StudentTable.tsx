import React, { ReactElement } from 'react'
import zhCN from 'antd/es/locale/zh_CN'
import { ConfigProvider, Button, Table, Modal, Form, Input, Select, message, Tooltip } from 'antd'
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'
import { history, connect } from 'umi'
import axios from '@/util/Axios'
import qs from 'qs'

class StudentTable extends React.Component<any, any> {
    state: any
    pagination = {
      pageSize: 10,
      total: 1000
    }

    columns = [{
      title: '用户名',
      dataIndex: 'userName',
      key: 'userName',
      width: 100
    }, {
      title: '性别',
      dataIndex: 'gender',
      key: 'gender',
      width: 60,
      render: (text: string) => text === 'm' ? '男' : '女'
    }, {
      title: '本地房产',
      dataIndex: 'localEstate',
      key: 'localEstate',
      width: 80,
      render: (text: string) => text === 'y' ? '有' : '无'
    }, {
      title: '婚姻',
      dataIndex: 'married',
      key: 'married',
      width: 50,
      render: (text: string) => text === 'y' ? '已婚' : '未婚'
    }, {
      title: '电话',
      dataIndex: 'phoneNumber',
      key: 'phoneNumber'
    }, {
      title: '微信',
      dataIndex: 'wechat',
      key: 'wechat'
    }, {
      title: '批次',
      dataIndex: 'batch',
      key: 'batch',
      width: 100
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
        studentList: [],
        deleteModal: false,
        studentToDel: null,
        total: 0,
        pageNum: 1,
        pageSize: 5,
        pagination: {
          pageSize: 5,
          total: 10,
          showTotal: (): string => `共${this.state.total}条`,
          onChange: (current: number): void => {
            this.setState({
              pageNum: current
            }, () => {
              this.getUserList()
            })
          }
        }
      }
    }

    getUserList (): void {
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
          this.state.pagination.total = data.data.totalRows
          this.setState({
            studentList: data.data.rows,
            pagination: Object.assign({}, this.state.pagination),
            total: data.data.totalRows
          })
        }
      })
    }

    componentDidMount (): void {
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
                  this.getUserList()
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

    render (): ReactElement {
      return (
        <React.Fragment>
          {this.renderDeleteModal()}
          <Table bordered size='middle' columns={this.columns} dataSource={this.state.studentList} pagination={this.state.pagination}></Table>
        </React.Fragment>
      )
    }
}

// export default StudentTable
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(StudentTable)
