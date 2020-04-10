import React, { ReactElement } from "react";
import { Form, Input, Button, Select, message } from 'antd'

class AddUser extends React.Component<any, any>{
    layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    }
    tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    }
    async onFinish(values: any){
        console.dir(values)
        const ret = await fetch(`/user/addUser?userName=${values.username}&password=${values.password}&role=${parseInt(values.role)}&state=A`)
        const res = await ret.json()
        console.dir(res)
    }
    render(): ReactElement {
        return (
            <React.Fragment>
                <Form
                    {...this.layout}
                    style={{
                        width: '50%'
                    }}
                    onFinish={this.onFinish.bind(this)}
                >
                    <Form.Item
                        label='用户名'
                        name='username'
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

export default AddUser