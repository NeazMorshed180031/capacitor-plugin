import Foundation

@objc public class camera: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
