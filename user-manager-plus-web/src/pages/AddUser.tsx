import React, { ReactElement } from "react";
import { Form, Input, Button, Select, message } from 'antd'
import { connect } from 'umi'

class AddUser extends React.Component<any, any>{
    layout = {
        labelCol: { span: 4 },
        wrapperCol: { span: 16 },
    }
    tailLayout = {
        wrapperCol: { offset: 10, span: 12 },
    }
    async onFinish(values: any) {
        const user = {
            userName: values.userName,
            password: values.password,
            role: parseInt(values.role),
            state: values.state
        }
        const ret = await fetch(`/user/addUser`, {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        const res = await ret.json()
        if (res.success) {
            message.success('添加用户成功')
        }
    }
    render(): ReactElement {
        return (
            <React.Fragment>
                <Form
                    {...this.layout}
                    style={{
                        width: '50%',
                        marginLeft: '25%'
                    }}
                    onFinish={this.onFinish.bind(this)}
                    initialValues={
                        this.props.ALL.editUser ? {
                            userName: this.props.ALL.editUser.userName,
                            role: this.props.ALL.editUser.role.toString()
                        } : {}
                    }
                >
                    <Form.Item
                        label='用户名'
                        name='userName'
                        rules={[{ required: true, message: '请输入用户名' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='密码'
                        name='password'
                        rules={[{ required: true, message: '请输入密码' }]}
                    >
                        <Input.Password />
                    </Form.Item>
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
            </React.Fragment>
        )
    }
}

export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(AddUser)