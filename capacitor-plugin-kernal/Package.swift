// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginKernal",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginKernal",
            targets: ["KernelInfoPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "KernelInfoPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/KernelInfoPluginPlugin"),
        .testTarget(
            name: "KernelInfoPluginPluginTests",
            dependencies: ["KernelInfoPluginPlugin"],
            path: "ios/Tests/KernelInfoPluginPluginTests")
    ]
)