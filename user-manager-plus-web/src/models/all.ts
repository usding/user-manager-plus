const AllModel = {
    namespace: 'ALL',

    state: {
        selKeys: [],
        user: null,
        editUser: null,
        editStudent: null,
    },

    reducers: {
        save(state:any, action:any){
            return {
                ...state,
                ...action.payload
            }
        },
        refresh(state:any, action: any){
            return {
                selKeys: [],
                user: null,
                editUser: null,
                editStudent: null
            }
        }
    }
}

export default AllModel