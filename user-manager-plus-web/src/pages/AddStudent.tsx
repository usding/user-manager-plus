import React, { ReactElement } from "react"
import zhCN from 'antd/es/locale/zh_CN';
import { Form, Input, Select, Button, DatePicker, ConfigProvider, Divider, InputNumber, Upload, message } from 'antd'
import { UploadOutlined, InboxOutlined } from '@ant-design/icons'
import moment from 'moment'
import ImageUtil from '@/util/ImageUtil'

class AddStudent extends React.Component<any, any>{
    state: any
    dateFormat = 'YYYY/MM/DD'
    constructor(props: any) {
        super(props)
        this.state = {
            idcardFrontImg: null,
            idcardBackImg: null,
            diplomaImg: null,
            portraitImg: null,
            testData:{
                studentName: '张三',
                birthDate: moment(new Date()),
                gender: 'm',
                race: 'han',
                idenType: 'A',
                idenId: '371121199012123456',
                localHouse: 'y',
                married: 'n',
                phoneNumber: '18445325643',
                hometown: '南京市江宁区秣陵街道东善乔花园小区4栋13号',
                idenAddress: '南京市江宁区秣陵街道东善乔花园小区4栋13号',
                followed: 'n',
                mailcode: '3245666',
                email: '32455532@qq.com',
                wechat: 'wasf2322',
                note: null,
                batch: 1,
                deposit: 3453,
                retainage: 4321,
                totalCost: 7774
            }
        }
    }
    layout = {
        labelCol: { span: 4 },
        wrapperCol: { span: 12 },
    }
    buttonLyout = {
        wrapperCol: { offset: 8, span: 16 },
    }
    onFinish(values: any): void {
        console.dir(values)
        const params = new URLSearchParams()
        params.append('userName', values.studentName)
        console.dir(values.birthDate.format('YYYY-MM-DD'))
        params.append('birthDate', values.birthDate.format('YYYY-MM-DD'))
        params.append('userSex', values.gender)
        params.append('celebrities', values.race)
        params.append('certType', values.idenType)
        params.append('certNumber', values.idenId)
        params.append('maritalStatus',values.married)
        params.append('localEstate', values.localHouse)
        params.append('phoneNumber', values.phoneNumber)
        params.append('domicile', values.hometown)
        params.append('certAddress', values.idenAddress)
        params.append('accompanyPerson',values.followed)
        params.append('postalCode',values.mailcode)
        params.append('email', values.email)
        params.append('wechat', values.wechat)
        params.append('note', values.note)
        params.append('batch', values.batch)
        params.append('deposit', values.deposit)
        params.append('finalPayment', values.retainage)
        params.append('totalCost',values.totalCost)
        params.append('certFscan', this.state.idcardFrontImg)
        params.append('certBscan', this.state.idcardBackImg)
        params.append('photoBlue', this.state.portraitImg)
        params.append('certGscan', this.state.diplomaImg)
        let ret = fetch('/student/addStudent',{
            method: 'POST',
            body: params
        })
    }
    imgToBase64(file: File): Promise<any> {
        return new Promise((resolve, reject) => {
            const reader = new FileReader()
            reader.readAsDataURL(file)
            reader.onload = (e) => {
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
                        width: '100%'
                    }}
                    onFinish={this.onFinish.bind(this)}
                    initialValues={this.state.testData}
                >
                    <h3>基础信息</h3>
                    <Divider />
                    <Form.Item
                        label='学员姓名'
                        name='studentName'
                        rules={[{ required: true, message: '请输入学员姓名' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='证件类型'
                        name='idenType'
                        rules={[{ required: true, message: '请选择证件类型' }]}
                    >
                        <Select>
                            <Select.Option value={1}>身份证</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='证件号码'
                        name='idenId'
                        rules={[{ required: true, message: '请填写证件号码' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='性别'
                        name='gender'
                        rules={[{ required: true, message: '请选择性别' }]}
                    >
                        <Select>
                            <Select.Option value='m' >男</Select.Option>
                            <Select.Option value='f' >女</Select.Option>
                        </Select>
                    </Form.Item>
                    <Form.Item
                        label='出生日期'
                        name='birthDate'
                        rules={[{ required: true, message: '请选择证出生日期' }]}
                    >
                        <ConfigProvider locale={zhCN}>
                            <DatePicker defaultValue={this.state.testData.birthDate} />
                        </ConfigProvider>
                    </Form.Item>
                    <Form.Item
                        label='户籍所在地'
                        name='hometown'
                        rules={[{ required: true, message: '户籍地址不能为空' }]}
                    >
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
                            <Select.Option value='y'>是</Select.Option>
                            <Select.Option value='n'>否</Select.Option>
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
                        name='phoneNumber'
                        rules={[{ required: true, message: '请输入手机号' }]}
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
                    <Form.Item
                        label='注释'
                        name='note'
                    >
                        <Input />
                    </Form.Item>
                    <h3>批次与金额</h3>
                    <Divider />
                    <Form.Item
                        label='批次'
                        name='batch'
                        rules={[{ required: true, message: '请输入批次' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label='定金'
                        name='deposit'
                        rules={[{ required: true, message: '请输入定金' }]}
                    >
                        <InputNumber />
                    </Form.Item>
                    <Form.Item
                        label='尾款'
                        name='retainage'
                        rules={[{ required: true, message: '请输入尾款' }]}
                    >
                        <InputNumber />
                    </Form.Item>
                    <Form.Item
                        label='总费用'
                        name='totalCost'
                        rules={[{ required: true, message: '请输入总费用' }]}
                    >
                        <InputNumber />
                    </Form.Item>
                    <h3>证件照</h3>
                    <Divider />
                    <Form.Item
                        label='身份证正面'
                        required
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
                                reader.onload = async (e) => {
                                    let img64 = reader.result
                                    if (typeof img64 === 'string') {
                                        console.log(img64.length)
                                        if (img64.length > 500 * 1024) {
                                            img64 = await ImageUtil.compress(img64, { w: 1000, h: 1000, level: 0.9 })
                                        }
                                        console.log(img64.length)
                                        this.setState({
                                            idcardFrontImg: img64
                                        })
                                    }

                                }
                                return isJpgOrPng
                            }}
                        >
                            {this.state.idcardFrontImg ? <img src={this.state.idcardFrontImg} alt="avatar" style={{ width: '400px' }} /> :
                                (<div>
                                    <div>点击上传</div>
                                </div>)}
                        </Upload>
                    </Form.Item>
                    <Form.Item
                        label='身份证反面'
                        required
                        rules={[{ required: true, message: '请选择身份证反面图片' }]}
                    >
                        <Upload
                            name='idcardBack'
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file): boolean => {
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e) => {
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
                            beforeUpload={(file): boolean => {
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e) => {
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
                        required
                    >
                        <Upload
                            name='diploma'
                            listType="picture-card"
                            className="avatar-uploader"
                            showUploadList={false}
                            beforeUpload={(file): boolean => {
                                const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
                                if (!isJpgOrPng) {
                                    message.error('You can only upload JPG/PNG file!')
                                    return isJpgOrPng
                                }
                                const reader = new FileReader()
                                reader.readAsDataURL(file)
                                reader.onload = (e) => {
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