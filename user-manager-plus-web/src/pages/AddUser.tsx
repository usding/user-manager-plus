import React, { ReactElement } from "react";
import { Form, Input, Button } from 'antd'

class AddUser extends React.Component<any, any>{
    layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    }
    tailLayout = {
        wrapperCol: { offset: 8, span: 16 },
    }
    onFinish(values: any):void{
        console.dir(values)
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
                    <Form.Item
                        label='手机号'
                        name='tel'
                        rules={[{ required: true, message: '请输入手机号' }]}
                    >
                        <Input />
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