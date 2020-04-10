import React, { ReactElement } from "react";
import { Form, Input, Button } from 'antd'
class Login extends React.Component<any, any> {
    layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    }
    tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    }

    render(): ReactElement {
        return (
            <React.Fragment>
                <div
                    style={{
                        width: '100%',
                        paddingTop: '20%',
                        paddingLeft: '30%'
                    }}
                >
                    <Form
                        {...this.layout}
                        style={{
                            width: '40%'
                        }}
                        onFinish={async (values: any)=>{
                            console.dir(values)
                            const res = await fetch(`/hetong/login?loginName=${values.username}&password=${values.password}`)
                            console.dir(res)
                        }}
                    >
                        <Form.Item
                            label="用户名"
                            name="username"
                            rules={[{ required: true, message: '请输入用户名!' }]}
                        >
                            <Input />
                        </Form.Item>

                        <Form.Item
                            label="密码"
                            name="password"
                            rules={[{ required: true, message: '请输入密码!' }]}
                        >
                            <Input.Password />
                        </Form.Item>
                        <Form.Item {...this.tailLayout}>
                            <Button type="primary" htmlType="submit">
                                登录
                        </Button>
                        </Form.Item>
                    </Form>
                </div>
            </React.Fragment>
        )
    }
}

export default Login