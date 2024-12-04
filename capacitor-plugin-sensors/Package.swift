// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginSensors",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginSensors",
            targets: ["sensorsPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "sensorsPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/sensorsPlugin"),
        .testTarget(
            name: "sensorsPluginTests",
            dependencies: ["sensorsPlugin"],
            path: "ios/Tests/sensorsPluginTests")
    ]
)