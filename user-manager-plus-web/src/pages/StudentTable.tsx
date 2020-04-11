import React, { ReactElement } from "react"
import { Button, Table, Modal, Form, Input, Select, message, Tooltip } from 'antd'
import { EditOutlined, DeleteOutlined, InfoCircleOutlined } from '@ant-design/icons'
import AddStudent from '@/pages/AddStudent'
import { history, connect } from 'umi'

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
        key: 'phoneNumber',
    }, {
        title: '操作',
        dataIndex: 'operation',
        key: 'operation',
        width: 120,
        render: (text: any, record: any) => {
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
                            onClick={() => {
                                // this.setState({
                                //     editModal: true
                                // })
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
                        ></Button>
                    </Tooltip>
                </React.Fragment>
            )
        }
    }]
    constructor(props: any) {
        super(props)
        this.state = {
            studentList: [],
            editModal: false,
            total: 0,
            pageNum: 1,
            pageSize: 10,
            pagination: {
                pageSize: 10,
                total: 10,
                showTotal: () => `共${this.state.total}条`,
                onChange: (current: any) => {
                    this.setState({
                        pageNum: current
                    }, () => {
                        this.getUserList()
                    })
                }
            }
        }
    }

    async getUserList() {
        const ret = await fetch(`/student/studentList?page=${this.state.pageNum}&size=${this.state.pageSize}`)
        const res = await ret.json()
        if (res.data) {
            const list = res.data.rows
            list.forEach((val: any) => {
                val.key = val.id
                val.operation = null
            })
        }
        this.state.pagination.total = res.data.totalRows
        this.setState({
            studentList: res.data.rows,
            pagination: Object.assign({}, this.state.pagination),
            total: res.data.totalRows
        })
    }

    componentDidMount() {
        this.getUserList()
    }
    renderEditModal(): ReactElement {
        return (
            <Modal
                title='编辑学员'
                visible={this.state.editModal}
                onCancel={() => { this.setState({ editModal: false }) }}
                width='80%'
                footer={null}
            >
                <AddStudent />
            </Modal>
        )
    }
    render(): ReactElement {
        return (
            <React.Fragment>
                {this.renderEditModal()}
                <Table bordered size='middle' columns={this.columns} dataSource={this.state.studentList} pagination={this.state.pagination}></Table>
            </React.Fragment>
        )
    }
}

// export default StudentTable
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(StudentTable)