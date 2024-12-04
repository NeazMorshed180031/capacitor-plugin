// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginCamera",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginCamera",
            targets: ["cameraPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "cameraPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/cameraPlugin"),
        .testTarget(
            name: "cameraPluginTests",
            dependencies: ["cameraPlugin"],
            path: "ios/Tests/cameraPluginTests")
    ]
)