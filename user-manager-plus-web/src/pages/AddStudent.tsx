import React, { ReactElement } from "react"
import zhCN from 'antd/es/locale/zh_CN';
import { Form, Input, Select, Button, DatePicker, ConfigProvider, Divider, InputNumber, Upload, message, Row, Col } from 'antd'
import { EditOutlined, DeleteOutlined, InfoCircleOutlined } from '@ant-design/icons'
import moment from 'moment'
import { history, connect } from 'umi'
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
            initValues: null,
            testData: {
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
        // const params = new URLSearchParams()
        // params.append('userName', values.studentName)
        // console.dir(values.birthDate.format('YYYY-MM-DD'))
        // params.append('birthDate', values.birthDate.format('YYYY-MM-DD'))
        // params.append('userSex', values.gender)
        // params.append('celebrities', values.race)
        // params.append('certType', values.idenType)
        // params.append('certNumber', values.idenId)
        // params.append('maritalStatus', values.married)
        // params.append('localEstate', values.localHouse)
        // params.append('phoneNumber', values.phoneNumber)
        // params.append('domicile', values.hometown)
        // params.append('certAddress', values.idenAddress)
        // params.append('accompanyPerson', values.followed)
        // params.append('postalCode', values.mailcode)
        // params.append('email', values.email)
        // params.append('wechat', values.wechat)
        // params.append('note', values.note)
        // params.append('batch', values.batch)
        // params.append('deposit', values.deposit)
        // params.append('finalPayment', values.retainage)
        // params.append('totalCost', values.totalCost)
        // params.append('certFscan', this.state.idcardFrontImg)
        // params.append('certBscan', this.state.idcardBackImg)
        // params.append('photoBlue', this.state.portraitImg)
        // params.append('certGscan', this.state.diplomaImg)
        const student = {
            id: null,
            userName: values.studentName,
            birthDate: values.birthDate.format('YYYY-MM-DD'),
            userSex: values.gender,
            celebrities: values.race,
            certType: values.idenType,
            certNumber: values.idenId,
            maritalStatus: values.married,
            localEstate: values.localHouse,
            phoneNumber: values.phoneNumber,
            domicile: values.hometown,
            certAddress: values.idenAddress,
            accompanyPerson: values.followed,
            postalCode: values.mailcode,
            email: values.email,
            wechat: values.wechat,
            note: values.note,
            batch: values.batch,
            deposit: values.deposit,
            finalPayment: values.retainage,
            totalCost: values.totalCost,
            certFscan: this.state.idcardFrontImg,
            certBscan: this.state.idcardBackImg,
            photoBlue: this.state.portraitImg,
            certGscan: this.state.diplomaImg
        }
        if (this.props.route.path === '/addStudent') {
            let ret = fetch('/student/addStudent', {
                method: 'POST',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify(student)
            })
        } else if (this.props.route.path === '/editStudent') {
            student.id = this.props.ALL.editStudent.id
            const ret = fetch('/student/editStudent', {
                method: 'POST',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify(student)
            })
        }

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
    async getStudentById(id: number) {
        let ret = await fetch(`/student/getStudent?id=${id}`)
        let res = await ret.json()
        console.dir(res)
        if (res.data) {
            const student = res.data
            this.setState({
                initValues: {
                    studentName: student.userName,
                    birthDate: moment(student.birthDate),
                    gender: student.userSex,
                    race: student.celebrities,
                    idenType: student.certType,
                    idenId: student.certNumber,
                    localHouse: student.localEstate,
                    married: student.maritalStatus,
                    phoneNumber: student.phoneNumber,
                    hometown: student.domicile,
                    idenAddress: student.certAddress,
                    followed: student.accompanyPerson,
                    mailcode: student.postalCode,
                    email: student.email,
                    wechat: student.wechat,
                    note: student.note,
                    batch: student.batch,
                    deposit: student.deposit,
                    retainage: student.finalPayment,
                    totalCost: student.totalCost
                },
                idcardFrontImg: (student.certFscan && student.certFscan.length > 100) ? student.certFscan : null,
                idcardBackImg: (student.certBscan && student.certBscan.length > 100) ? student.certBscan : null,
                diplomaImg: (student.certGscan && student.certGscan.length > 100) ? student.certGscan : null,
                portraitImg: (student.photoBlue && student.photoBlue.length > 100) ? student.photoBlue : null,
            })
        }
    }
    componentDidMount() {
        if (this.props.route.path === '/editStudent') {
            if (this.props.ALL.editStudent) {
                this.getStudentById(this.props.ALL.editStudent.id)
            }
        } else if (this.props.route.path === '/addStudent') {
            this.setState({
                idcardFrontImg: null,
                idcardBackImg: null,
                diplomaImg: null,
                portraitImg: null
            })
        }

    }
    componentWillUnmount(): void {
        // this.props.dispatch({
        //     type: 'ALL/save',
        //     payload: {
        //         editStudent: null
        //     }
        // })
    }
    render(): ReactElement | null {
        if (this.props.route.path === '/editStudent' && !this.props.ALL.editStudent) {
            return (
                <h3>请在学员列表中选择一个学员编辑</h3>
            )
        }
        if (this.props.route.path === '/editStudent' && this.state.initValues === null) {
            return null
        }
        return (
            <React.Fragment>
                <Form
                    // {...this.layout}
                    style={{
                        width: '100%'
                    }}
                    onFinish={this.onFinish.bind(this)}
                    initialValues={this.props.route.path === '/editStudent' ? this.state.initValues : null}
                >
                    <h3>基础信息</h3>
                    <Divider />
                    <Row>
                        <Col span={8}>
                            <Form.Item
                                // labelCol={{ span: 5 }}
                                // wrapperCol={{ span: 17 }}
                                label='学员姓名'
                                name='studentName'
                                rules={[{ required: true, message: '请输入学员姓名' }]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={3}>
                            <Form.Item
                                labelCol={{ span: 12 }}
                                wrapperCol={{ span: 10 }}
                                label='性别'
                                name='gender'
                                rules={[{ required: true, message: '请选择性别' }]}
                            >
                                <Select>
                                    <Select.Option value='m' >男</Select.Option>
                                    <Select.Option value='f' >女</Select.Option>
                                </Select>
                            </Form.Item>
                        </Col>

                        <Col span={5}>
                            <Form.Item
                                labelCol={{ span: 12 }}
                                wrapperCol={{ span: 10 }}
                                label='婚姻状况'
                                name='married'
                            >
                                <Select>
                                    <Select.Option value='y'>已婚</Select.Option>
                                    <Select.Option value='n'>未婚</Select.Option>
                                </Select>
                            </Form.Item>
                        </Col>
                        <Col span={4}>
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
                        </Col>
                    </Row>

                    <Row>
                        <Col span={4}>
                            <Form.Item
                                // labelCol={{ span: 10 }}
                                // wrapperCol={{ span: 12 }}
                                label='证件类型'
                                name='idenType'
                                rules={[{ required: true, message: '请选择证件类型' }]}
                            >
                                <Select>
                                    <Select.Option value='A'>身份证</Select.Option>
                                </Select>
                            </Form.Item>
                        </Col>
                        <Col span={8}>
                            <Form.Item
                                labelCol={{ span: 6 }}
                                wrapperCol={{ span: 17 }}
                                label='证件号码'
                                name='idenId'
                                rules={[{ required: true, message: '请填写证件号码' }]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={6}>
                            <Form.Item
                                label='出生日期'
                                name='birthDate'
                                rules={[{ required: true, message: '请选择证出生日期' }]}
                            >
                                <ConfigProvider locale={zhCN}>
                                    <DatePicker defaultValue={this.state.testData.birthDate} />
                                </ConfigProvider>
                            </Form.Item>
                        </Col>

                    </Row>
                    <Row>
                        <Col span={6}>
                            <Form.Item
                                label='手机号'
                                name='phoneNumber'
                                rules={[{ required: true, message: '请输入手机号' }]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={1}></Col>
                        <Col span={16}>
                            <Form.Item
                                label='户籍所在地'
                                name='hometown'
                                rules={[{ required: true, message: '户籍地址不能为空' }]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row>
                        <Col span={4}>
                            <Form.Item
                                label='本地房产'
                                name='localHouse'
                            >
                                <Select>
                                    <Select.Option value='y'>有</Select.Option>
                                    <Select.Option value='n'>无</Select.Option>
                                </Select>
                            </Form.Item>
                        </Col>
                        <Col span={4}>
                            <Form.Item
                                labelCol={{ span: 12 }}
                                wrapperCol={{ span: 11 }}
                                label='随迁人员'
                                name='followed'
                            >
                                <Select>
                                    <Select.Option value='y'>是</Select.Option>
                                    <Select.Option value='n'>否</Select.Option>
                                </Select>
                            </Form.Item>
                        </Col>
                        <Col span={4}>
                            <Form.Item
                                labelCol={{ span: 10 }}
                                wrapperCol={{ span: 14 }}
                                label='邮政编码'
                                name='mailcode'
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={6}>
                            <Form.Item
                                labelCol={{ span: 8 }}
                                wrapperCol={{ span: 16 }}
                                label='邮箱'
                                name='email'
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>

                    <Row>
                        <Col span={6}>
                            <Form.Item
                                label='微信号'
                                name='wechat'
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={1}></Col>
                        <Col span={14}>
                            <Form.Item
                                label='身份证地址'
                                name='idenAddress'
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>
                    <Row>
                        <Col span={22}>
                            <Form.Item
                                label='注释'
                                name='note'
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                    </Row>
                    <h3>批次与金额</h3>
                    <Divider />
                    <Row>
                        <Col span={4}>
                            <Form.Item
                                label='批次'
                                name='batch'
                                rules={[{ required: true, message: '请输入批次' }]}
                            >
                                <Input />
                            </Form.Item>
                        </Col>
                        <Col span={6}>
                            <Form.Item
                                labelCol={{ span: 6 }}
                                wrapperCol={{ span: 17 }}
                                label='定金'
                                name='deposit'
                                rules={[{ required: true, message: '请输入定金' }]}
                            >
                                <InputNumber style={{ width: '100px' }} />
                            </Form.Item>
                        </Col>
                        <Col span={6}>
                            <Form.Item
                                label='尾款'
                                name='retainage'
                                rules={[{ required: true, message: '请输入尾款' }]}
                            >
                                <InputNumber />
                            </Form.Item>
                        </Col>
                        <Col span={6}>
                            <Form.Item
                                label='总费用'
                                name='totalCost'
                                rules={[{ required: true, message: '请输入总费用' }]}
                            >
                                <InputNumber />
                            </Form.Item>
                        </Col>
                    </Row>

                    <h3>证件照</h3>
                    <Divider />
                    <Row>
                        <Col span={12}>
                            <Form.Item
                                label='身份证正面'
                                required
                            >
                                {/* <Upload
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
                                                this.setState({
                                                    idcardFrontImg: img64
                                                })
                                            }

                                        }
                                        return isJpgOrPng
                                    }}
                                >
                                    {this.state.idcardFrontImg ?
                                        <div>
                                            <img src={this.state.idcardFrontImg} alt="avatar" style={{ width: '400px' }} />
                                            <Button type='danger' icon={<DeleteOutlined />} shape='circle'
                                                style={{
                                                    marginTop: '0.5rem'
                                                }}
                                                onClick={(e) => {
                                                    e.preventDefault()
                                                    e.stopPropagation()
                                                    this.setState({
                                                        idcardFrontImg: null
                                                    })
                                                }}
                                            ></Button>
                                        </div>
                                        :
                                        (<div>
                                            <div>点击上传</div>
                                        </div>)}
                                </Upload> */}
                                {this.renderImg('idcardFrontImg')}
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                label='身份证反面'
                                required
                                rules={[{ required: true, message: '请选择身份证反面图片' }]}
                            >
                                {/* <Upload
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
                                </Upload> */}
                                {this.renderImg('idcardBackImg')}
                            </Form.Item>
                        </Col>
                    </Row>

                    <Row>
                        <Col span={12}>
                            <Form.Item
                                label='毕业证书'
                            >
                                {/* <Upload
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
                                </Upload> */}
                                {this.renderImg('diplomaImg')}
                            </Form.Item>
                        </Col>
                        <Col span={12}>
                            <Form.Item
                                label='2寸蓝底照片'
                                required
                            >
                                {/* <Upload
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
                                </Upload> */}
                                {this.renderImg('portraitImg')}
                            </Form.Item>
                        </Col>
                    </Row>


                    <Form.Item {...this.buttonLyout} >
                        <Button type='primary' htmlType='submit'>确定</Button>
                    </Form.Item>
                </Form>
            </React.Fragment>
        )
    }

    renderImg(imgName: string): ReactElement {
        return (
            <Upload
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
                            if (img64.length > 500 * 1024) {
                                img64 = await ImageUtil.compress(img64, { w: 1000, h: 1000, level: 0.9 })
                            }
                            this.setState({
                                [imgName]: img64
                            })
                        }

                    }
                    return isJpgOrPng
                }}
            >
                {this.state[imgName] ?
                    <div>
                        <img src={this.state[imgName]} alt="avatar" style={{ width: '400px' }} />
                        <Button type='danger' icon={<DeleteOutlined />} shape='circle'
                            style={{
                                marginTop: '0.5rem'
                            }}
                            onClick={(e) => {
                                e.preventDefault()
                                e.stopPropagation()
                                this.setState({
                                    [imgName]: null
                                })
                            }}
                        ></Button>
                    </div>
                    :
                    (<div>
                        <div>点击上传</div>
                    </div>)}
            </Upload>
        )
    }
}

// export default AddStudent
export default connect(({ ALL }: { ALL: any }) => ({ ALL }))(AddStudent)