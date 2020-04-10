const AllModel = {
    namespace: 'ALL',

    state: {
        selKeys: [],
        user: null,
        editUser: null
    },

    reducers: {
        save(state:any, action:any){
            return {
                ...state,
                ...action.payload
            }
        }
    }
}

export default AllModel