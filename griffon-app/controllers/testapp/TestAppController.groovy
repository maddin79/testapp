package testapp

class TestAppController {
    // these will be injected by Griffon
    def model
    def view

    def onStartupEnd = { app ->
        withHibernate4 { String dataSourceName, session ->
            List<Person> tmpList = []
            tmpList.addAll session.createQuery('from Person').list()
            if(tmpList.empty){
                withMVCGroup('firstUser') { m, v, c ->  
                    m.title = 'Add a new user'  
                    // m.message = 'Hallo'  
                    c.show() 
                }
            }
            tmpList.addAll session.createQuery('from Person').list()
            model.count = tmpList.size().toString()
        }
        
    }
    
    void mvcGroupInit(Map args) {
        
    }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    /*
    Remember that actions will be called outside of the UI thread
    by default. You can change this setting of course.
    Please read chapter 9 of the Griffon Guide to know more.
       
    def action = { evt = null ->
    }
     */
}
