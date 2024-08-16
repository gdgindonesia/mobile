import SwiftUI
import app

@main
struct iOSApp: App {

    init() {
        ProvidersKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}