declare interface Result<T>{
    success: boolean;
    data: T;
    code: number;
    msg: string;
}
