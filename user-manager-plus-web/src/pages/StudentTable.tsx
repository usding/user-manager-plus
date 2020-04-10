import React, { ReactElement } from "react";
import { Button, Table, Modal, Form, Input, Select, message } from 'antd'

class StudentTable extends React.Component<any, any> {
    state: any
    pagination = {
        pageSize: 10
    }
    columns = [{
        title: '用户名',
        dataIndex: 'userName',
        key: 'userName'
    },{
        title: '性别',
        dataIndex: 'userSex',
        key: 'userSex'
    },{
        title: '电话',
        dataIndex: 'phoneNumber',
        key: 'phoneNumber'
    },{
        title: '操作',
        dataIndex: 'operation',
        key: 'operation'
    }]
    constructor(props: any){
        super(props)
        this.state={
            studentList: []
        }
    }

    async componentDidMount(){
        const ret = await fetch('/student/studentList')
        const res = await ret.json()
        this.setState({
            studentList: res.data
        })
    }
    render(): ReactElement{
        return (
            <React.Fragment>
                <Table bordered size='middle' columns={this.columns} dataSource={this.state.studentList} pagination={this.pagination}></Table>
            </React.Fragment>
        )
    }
}

export default StudentTable