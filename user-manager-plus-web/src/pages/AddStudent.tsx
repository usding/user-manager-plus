import React, { ReactElement } from "react"
import zhCN from 'antd/es/locale/zh_CN';
import { Form, Input, Select, Button, DatePicker, ConfigProvider, Divider, InputNumber, Upload, message } from 'antd'
import { UploadOutlined, InboxOutlined } from '@ant-design/icons'

class AddStudent extends React.Component<any, any>{
    state: any
    constructor(props: any) {
        super(props)
        this.state = {
            idcardFrontImg: null,
            idcardBackImg: null,
            diplomaImg: null,
            portraitImg: null
        }
    }
    layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 16 },
    }
    buttonLyout = {
        wrapperCol: { offset: 8, span: 16 },
    }
    onFinish(values: any): void {
        console.dir(values)
    }
    imgToBase64(file: File): Promise<any> {
        return new Promise((resolve, reject)=>{
            const reader = new FileReader()
            reader.readAsDataURL(file)
            reader.onload=(e)=>{
                resolve(reader.result)
            }
        })
    }
    render(): ReactElement {
        return (
            <React.Fragment>

                <Form
                    {...this.layout}
                    style={{
                        width: '40%'
                    }}
                    onFinish={this.onFinish.bind(this)}
                >
                    <h3>基础信息</h3>
                    <Divider />
                    <Form.Item
                        label='学员姓名'
                        name='sutdentName'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='证件类型'
                        name='idenType'
                    >
                        <Select>
                            <Select.Option value={1}>身份证</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='证件号码'
                        name='idenId'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='性别'
                        name='gender'
                    >
                        <Select>
                            <Select.Option value='m' >男</Select.Option>
                            <Select.Option value='f' >女</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='出生日期'
                    >
                        <ConfigProvider locale={zhCN}>
                            <DatePicker />
                        </ConfigProvider>
                    </Form.Item>
                    <Form.Item
                        label='户籍所在地'
                        name='hometown'>
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='民族'
                        name='race'
                    >
                        <Select>
                            <Select.Option value='han'>汉族</Select.Option>
                            <Select.Option value='man'>满族</Select.Option>
                            <Select.Option value='zhuang'>壮族</Select.Option>
                            <Select.Option value='other'>其它</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='本地房产'
                        name='localHouse'
                    >
                        <Select>
                            <Select.Option value='true'>是</Select.Option>
                            <Select.Option value='false'>否</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='婚姻状况'
                        name='married'
                    >
                        <Select>
                            <Select.Option value='y'>是</Select.Option>
                            <Select.Option value='n'>否</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='随迁人员'
                        name='followed'
                    >
                        <Select>
                            <Select.Option value='y'>是</Select.Option>
                            <Select.Option value='n'>否</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='手机号'
                        name='tel'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='邮政编码'
                        name='mailcode'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='身份证地址'
                        name='idenAddress'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='邮箱'
                        name='email'
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='微信号'
                        name='wechat'
                    >
                        <Input />
                    </Form.Item>
                    <h3>批次与金额</h3>
                    <Divider />
                    <Form.Item
                        label='批次'
                        name='batch'
                    >
                        <InputNumber />
                    </Form.Item>
                    <Form.Item
                        label='定金'
                        name='deposit'
                    >
                        <InputNumber />
                    </Form.Item>
                    <Form.Item
                        label='尾款'
                        name='retainage'
                    >
                        <InputNumber />
                    </Form.Item>
                    <Form.Item
                        label='总费用'
                        name='totalCost'
                    >
                        <InputNumber />
                    </Form.Item>
                    <h3>证件照</h3>
                    <Divider />
                    <Form.Item
                        label='身份证正面'
                    >
                        <Upload
                            name="idcardFront"
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file: any): boolean => {
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e)=>{
                                    this.setState({
                                        idcardFrontImg: reader.result
                                    })
                                }
                                return isJpgOrPng
                            }}
                        >
                            {this.state.idcardFrontImg ? <img src={this.state.idcardFrontImg} alt="avatar" style={{ width: '100%' }} /> :
                                (<div>
                                    <div>点击上传</div>
                                </div>)}
                        </Upload>
                    </Form.Item>
                    <Form.Item
                        label='身份证反面'
                    >
                        <Upload
                            name='idcardBack'
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file): boolean=>{
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e)=>{
                                    this.setState({
                                        idcardBackImg: reader.result
                                    })
                                }
                                return isJpgOrPng
                            }}
                        >
                            {this.state.idcardBackImg ? <img src={this.state.idcardBackImg} alt="avatar" style={{ width: '100%' }} /> :
                                (<div>
                                    <div>点击上传</div>
                                </div>)}
                        </Upload>
                    </Form.Item>
                    <Form.Item
                        label='毕业证书'
                    >
                        <Upload
                            name='diploma'
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file): boolean=>{
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e)=>{
                                    this.setState({
                                        diplomaImg: reader.result
                                    })
                                }
                                return isJpgOrPng
                            }}
                        >
                            {this.state.diplomaImg ? <img src={this.state.diplomaImg} alt="avatar" style={{ width: '100%' }} /> :
                                (<div>
                                    <div>点击上传</div>
                                </div>)}
                        </Upload>
                    </Form.Item>
                    <Form.Item
                        label='2寸蓝底照片'
                    >
                        <Upload
                            name='diploma'
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file): boolean=>{
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e)=>{
                                    this.setState({
                                        portraitImg: reader.result
                                    })
                                }
                                return isJpgOrPng
                            }}
                        >
                            {this.state.portraitImg ? <img src={this.state.portraitImg} alt="avatar" style={{ width: '100%' }} /> :
                                (<div>
                                    <div>点击上传</div>
                                </div>)}
                        </Upload>
                    </Form.Item>
                    <Form.Item {...this.buttonLyout} >
                        <Button htmlType='submit'>确定</Button>
                    </Form.Item>
                </Form>
            </React.Fragment>
        )
    }
}

export default AddStudent