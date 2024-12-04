// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginScreensize",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginScreensize",
            targets: ["screensizePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "screensizePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/screensizePlugin"),
        .testTarget(
            name: "screensizePluginTests",
            dependencies: ["screensizePlugin"],
            path: "ios/Tests/screensizePluginTests")
    ]
)