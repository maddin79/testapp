package testapp

import java.awt.Window
import griffon.transform.Threading

class FirstUserController {
    def model
    def view
    def builder

    protected dialog

    @Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
    void show(Window window) {
        window = window ?: Window.windows.find{it.focused}
        if(!dialog || dialog.owner != window) {
            app.windowManager.hide(dialog)
            dialog = builder.dialog(
                owner: window,
                title: model.title,
                resizable: model.resizable,
                modal: model.modal) {
                container(view.content)
            }
            if(model.width > 0 && model.height > 0) {
                dialog.preferredSize = [model.width, model.height]
            }
            dialog.pack()
        }
        println(window)
        // int x = window.x + (window.width - dialog.width) / 2
        // int y = window.y + (window.height - dialog.height) / 2
        // dialog.setLocation(x, y)
        app.windowManager.show(dialog)
    }

    @Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
    def hide = { evt = null ->
        app.windowManager.hide(dialog)
        dialog = null
    }
    
    def saveUser = { evt = null ->
        withHibernate4 { String dataSourceName, session ->
            Person p = new Person()
            p.name = model.name
            p.password = model.password
            
            session.save(p)
            
            List<Person> tmpList = []
            tmpList.addAll session.createQuery('from Person').list()
            int count = tmpList.size()
            println("Count: " + count)
            app.models['testApp'].count = count
            println app.models['testApp'].count
        }   
        
        hide()
    }
}
