// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorPluginRam",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorPluginRam",
            targets: ["RamInfoPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "RamInfoPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/RamInfoPluginPlugin"),
        .testTarget(
            name: "RamInfoPluginPluginTests",
            dependencies: ["RamInfoPluginPlugin"],
            path: "ios/Tests/RamInfoPluginPluginTests")
    ]
)