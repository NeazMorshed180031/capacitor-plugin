// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginAppsize",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginAppsize",
            targets: ["appsizePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "appsizePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/appsizePlugin"),
        .testTarget(
            name: "appsizePluginTests",
            dependencies: ["appsizePlugin"],
            path: "ios/Tests/appsizePluginTests")
    ]
)