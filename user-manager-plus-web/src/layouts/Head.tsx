import React, { ReactElement } from "react";
import { Menu, Button, Dropdown } from 'antd'
import { history, connect } from 'umi';
import {
    DownOutlined
} from '@ant-design/icons';

class Head extends React.Component<any, any> {
    state: any
    constructor(props: any) {
        super(props);
        this.state = {
            collapsed: false
        }
    }

    async logout(){
        const ret = await fetch('/logout')
        const res = await ret.json()
        if(res.success){
            this.props.dispatch({
                type:'ALL/save',
                payload:{
                    user: null
                }
            })
            history.push('/login')
        }
    }
    render(): ReactElement {
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
                    <a>
                        更改密码
                    </a>
                </Menu.Item>
            </Menu>
        );
        return (
            <React.Fragment>
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
                    defaultSelectedKeys={this.props.ALL.selKeys}
                    selectedKeys={this.props.ALL.selKeys}
                    inlineCollapsed={this.state.collapsed}
                    onClick={(params: any) => {
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
                    </Menu.SubMenu>
                </Menu>
            </React.Fragment>

        )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(Head)