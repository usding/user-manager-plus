const AllModel = {
    namespace: 'ALL',

    state: {
        selKeys: []
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