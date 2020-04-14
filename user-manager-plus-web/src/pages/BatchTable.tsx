import React, { ReactElement } from 'react'
import zhCN from 'antd/es/locale/zh_CN'
import { ConfigProvider, Button, Table, Modal, Form, Input, Space, message, Row, Col } from 'antd'
import { history, connect } from 'umi'
import { EditOutlined, DeleteOutlined } from '@ant-design/icons'
import qs from 'qs'
import axios from '@/util/Axios'
class BatchTable extends React.Component<any, any> {
    state: any
    formRef: any = React.createRef()
    columns=[
      {
        title: '批次名',
        dataIndex: 'name',
        key: 'name'
      },
      {
        title: '描述',
        dataIndex: 'desc',
        key: 'desc'
      },
      {
        title: '操作',
        dataIdnex: 'operation',
        key: 'operation',
        width: 100,
        render: (record: any): ReactElement => {
          return (
            <React.Fragment>
              <Button
                type='primary'
                size='small'
                icon={<EditOutlined />}
                shape='circle'
                onClick={(): void => {
                  console.dir(record)
                  this.setState({
                    addModal: true,
                    operationType: 2,
                    editBatch: record
                  }, () => {
                    if (this.formRef.current) {
                      this.formRef.current.setFieldsValue({
                        name: record.name,
                        desc: record.desc
                      })
                      return
                    }
                    const i = setInterval(() => {
                      console.dir(this.formRef.current)
                      if (this.formRef.current) {
                        clearInterval(i)
                      }
                      this.formRef.current.setFieldsValue({
                        name: record.name,
                        desc: record.desc
                      })
                    }, 100)
                  })
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
                  this.setState({
                    deleteModal: true,
                    deleteBatch: record
                  })
                }}
              ></Button>
            </React.Fragment>
          )
        }
      }
    ]

    constructor (props: any) {
      super(props)
      this.state = {
        batchList: [],
        addModal: false,
        operationType: 1,
        editBatch: null,
        deleteBatch: null,
        deleteModal: false
      }
    }

    getBatchList (): void{
      axios.get('/batch/batchList').then(({ data }) => {
        if (data.success) {
          console.dir(data.data)
          data.data.forEach((batch: any): void => {
            batch.key = batch.id
          })
          this.setState({
            batchList: data.data
          })
        }
      })
    }

    componentDidMount (): void{
      this.getBatchList()
    }

    renderAddModal (): ReactElement {
      return (
        <Modal
          title={this.state.operationType === 1 ? '添加批次' : '编辑批次'}
          visible={this.state.addModal}
          footer={null}
          onCancel={(): void => {
            this.setState({
              addModal: false,
              editBatch: null
            })
            this.formRef.current.setFieldsValue({
              name: null,
              desc: null
            })
          }}
        >
          <Form
            ref={this.formRef}
            initialValues={this.state.editBatch}
            onFinish={(values): void => {
              const batch: any = {
                name: values.name,
                desc: values.desc
              }
              if (this.state.operationType === 1) {
                axios.post('/batch/addBatch', batch).then(({ data }) => {
                  if (data.success) {
                    message.success('添加成功')
                    this.getBatchList()
                    this.getBatchList()
                    this.setState({
                      addModal: false
                    })
                  }
                })
              } else if (this.state.operationType === 2) {
                batch.id = this.state.editBatch.id
                axios.post('/batch/editBatch', batch).then(({ data }) => {
                  if (data.success) {
                    message.success('编辑批次成功')
                    this.getBatchList()
                    this.setState({
                      addModal: false
                    })
                  }
                })
              }
            }}
          >
            <Form.Item
              labelCol={{ span: 4 }}
              label='批次名字'
              name='name'
              rules={[{ required: true, message: '请输入批次名字' },
                { max: 12, message: '批次名字长度不能超过12，更多信息请写到批次描述里' }]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              labelCol={{ span: 4 }}
              label='批次描述'
              name='desc'
            >
              <Input />
            </Form.Item>
            <Form.Item
              wrapperCol={{ span: 2, offset: 10 }}
            >
              <Button type='primary' htmlType='submit'>确定</Button>
            </Form.Item>
          </Form>
        </Modal>
      )
    }

    renderDeleteModal (): ReactElement {
      return (
        <Modal
          title='删除批次'
          visible={this.state.deleteModal}
          onCancel={(): void => {
            this.setState({
              deleteModal: false
            })
          }}
          onOk={(): void => {
            axios.get('/batch/deleteBatch', {
              params: {
                id: this.state.deleteBatch.id
              }
            }).then(({ data }) => {
              if (data.success) {
                message.success('删除成功')
                this.getBatchList()
                this.setState({
                  deleteModal: false
                })
              }
            })
          }}
        >
          <p>确定删除批次：{this.state?.deleteBatch?.name} ?</p>
        </Modal>
      )
    }

    render (): ReactElement {
      return (
        <React.Fragment>
          <ConfigProvider locale={zhCN}>
            {this.renderAddModal()}
            {this.renderDeleteModal()}
          </ConfigProvider>
          <Row>
            <Col span={2}>
              <Button type='primary'
                onClick={(): void => {
                  this.setState({
                    addModal: true,
                    operationType: 1
                  })
                }}
              >添加批次</Button>
            </Col>
          </Row>
          <p></p>
          <Table bordered size='middle' columns={this.columns} dataSource={this.state.batchList}></Table>
        </React.Fragment>
      )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(BatchTable)
