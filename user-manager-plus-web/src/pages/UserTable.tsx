import React, { ReactElement } from "react"
import { Button, Table } from 'antd'
import { history, connect } from 'umi'

class UserTable extends React.Component<any, any> {
    state: any
    columns = [{
        title: '用户名',
        dataIndex: 'userName',
        key: 'userName'
    }, {
        title: '角色',
        dataIndex: 'userRole',
        key: 'userRole'
    }, {
        title: '手机号',
        dataIndex: 'userTel',
        key: 'userTel'
    }, {
        title: '注册时间',
        dataIndex: 'registerDate',
        key: 'registerDate'
    }, {
        title: '用户状态',
        dataIndex: 'userState',
        key: 'userState'
    }, {
        title: '操作',
        dataIdnex: 'operation',
        key: 'operation'
    }]
    pagination = {
        pageSize: 10
    }
    constructor(props: any) {
        super(props)
        let users = []
        for (let i = 0; i < 20; i++) {
            users.push({
                key: i,
                userName: `user${i}`,
                userRole: i,
                userTel: `176543123${i}`,
                registerDate: new Date().toLocaleDateString(),
                userState: 'A',
            })
        }
        this.state = {
            users: users
        }
    }

    render(): ReactElement {
        return (
            <React.Fragment>
                <div
                    style={{
                        width: '100%'
                    }}
                >
                    <Button type='primary'
                        onClick={(): void => {
                            history.push('/addUser')
                            this.props.dispatch({
                                type: 'ALL/save',
                                payload: {
                                    selKeys: ['1.2']
                                }
                            })
                        }}
                    >
                        添加用户
                    </Button>
                </div>
                <Table bordered size='middle' columns={this.columns} dataSource={this.state.users} pagination={this.pagination}></Table>
            </React.Fragment>
        )
    }
}
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(UserTable)