
import random

class QSort:
    
    @staticmethod
    def sort(arr, low, high):
        if low < high:
            pivot = QSort.partition(arr, low, high)
            QSort.sort(arr, low, pivot - 1)
            QSort.sort(arr, pivot + 1, high)
            
    @staticmethod
    def partition(arr, low, high):
        # 随机选择一个元素作为 pivot，并将其与 low 位置的元素交换
        pivot_idx = random.randint(low, high)
        arr[low], arr[pivot_idx] = arr[pivot_idx], arr[low]
        
        pivot = arr[low]
        i = low
        j = high
        while i < j: # 双指针法
            while i < j and arr[j] >= pivot: j-=1
            if i < j:
                arr[i], arr[j] = arr[j], arr[i]
        arr[low], arr[i] = arr[i], arr[low]
        return i