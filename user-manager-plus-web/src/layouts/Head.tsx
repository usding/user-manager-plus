import React, { ReactElement } from "react";
import { Menu, Button } from 'antd'
import { history, connect } from 'umi';
import {
    AppstoreOutlined,
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    PieChartOutlined,
    DesktopOutlined,
    ContainerOutlined,
    MailOutlined,
} from '@ant-design/icons';

class Head extends React.Component<any, any> {
    state: any
    constructor(props: any) {
        super(props);
        this.state = {
            collapsed: false
        }
    }
    render(): ReactElement {
        return (
            <React.Fragment>
                <div
                    style={{
                        position: 'absolute',
                        top: 0,
                        width: '100%',
                        height: '3rem',
                        backgroundColor: 'white',
                        boxShadow: '0 0 5px 2px rgba(158,158,158, 0.3)'
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