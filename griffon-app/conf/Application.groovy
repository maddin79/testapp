application {
    title = 'TestApp'
    startupGroups = ['testApp']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "mainView"
    'mainView' {
        model      = 'testapp.MainViewModel'
        view       = 'testapp.MainView'
        controller = 'testapp.MainViewController'
    }

    // MVC Group for "firstUser"
    'firstUser' {
        model      = 'testapp.FirstUserModel'
        view       = 'testapp.FirstUserView'
        controller = 'testapp.FirstUserController'
    }

    // MVC Group for "second"
    'second' {
        model      = 'testapp.SecondModel'
        view       = 'testapp.SecondView'
        controller = 'testapp.SecondController'
    }

    // MVC Group for "testApp"
    'testApp' {
        model      = 'testapp.TestAppModel'
        view       = 'testapp.TestAppView'
        controller = 'testapp.TestAppController'
    }
}
