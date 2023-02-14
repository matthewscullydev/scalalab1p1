package lab1
class DimException extends Exception("Dims of Matrix must be equivalent")
def sum(arr: Array[Array[Double]], arr2: Array[Array[Double]]): Array[Array[Double]]  = {
  for (i <- 0 until arr2.length) {
    for (j <- 0 until arr2.length) {
      arr(i)(j) = arr(i)(j) + arr2(i)(j)
    }
  }
  arr
}

def trace(mat: Array[Array[Double]]) = {
  var sum = 0.0
  var indexer = 0
  for (i <- 0 until mat.length) {
    sum += mat(i)(indexer)
    indexer += 1
  }
  sum
}

def dot(vec1: Array[Double], vec2: Array[Double]): Double = {
  var sum = 0.0
  for(i <- 0 until vec2.length){
      vec1(i) = vec1(i) * vec2(i)
  }
  sum += vec1(0) + vec1(1) + vec1(2)
  sum
}

def product (arr:Array[Array[Double]],arr2:Array[Double]): Array[Double] = {
  var returnArr = Array(0.0,0.0,0.0)
  for (i <- 0 until arr.length) {
    for (j <- 0 until arr.length) {
      arr(i)(j) = arr(i)(j) * arr2(j)
    }
    returnArr(i) += arr(i)(0) + arr(i)(1) + arr(i)(2)
  }
  returnArr
}

def dim(mat: Array[Array[Double]]) : (Int,Int) = {
    val returnPair = (mat.length,mat.array(1).length)
    if(returnPair._1 != returnPair._2){
      throw DimException()
    }
    returnPair
}

def vec2string(vec: Array[Double]): String = {
    vec.mkString(",")
}

def mat2string(mat: Array[Array[Double]]): String = {
    mat.map(_.mkString(",")).mkString("\n")
    //mat.mkString(",")
}

def sum (arr:Array[Double],arr2:Array[Double]): Array[Double] = {
  //var returnArr = Array(Double)
  for(i <- 0 to arr2.length-1){
    arr(i) = arr(i) + arr2(i)
  }
  arr
}

def transpose(mat: Array[Array[Double]]): Array[Array[Double]] = {

  var returnArr = Array.ofDim[Double](mat.array.length, mat.length)
  var indexer = 0
  for (i <- 0 until mat.length) {
    for (j <- 0 until mat.array.length) {
      returnArr(indexer)(i) += mat(i)(j)
      indexer +=1
    }
    indexer = 0
  }
  returnArr
}

@main def LinearAlgebraTests() =
  try {
    val vec1 = Array(5.0, 2.0, 6.0)
    val mat1 = Array(Array(1.0, 2.0, 3), Array(4.0, 5, 6), Array(7.0, 8, 9))
    val mat2 = Array(Array(10.0, 11, 12), Array(13.0, 14, 15), Array(16.0, 17, 18))
    val mat3 = Array(Array(10.0, 11), Array(13.0, 14), Array(16.0, 17))
    println("vec1 = " + vec2string(vec1))
    println("mat1 = ")
    println(mat2string(mat1))
    println("mat2 = ")
    println(mat2string(mat2))
    println("dim(mat1) = " + dim(mat1))
    println("trace(mat1) = " +trace(mat1))
    println("transpose(mat2) = ")
    println(mat2string(transpose(mat2)))
    println("sum(mat1, mat2) = " + mat2string(sum(mat1,mat2)))
    println("product(mat1, vec1) = " + vec2string(product(mat1, vec1)))

    println("dim(mat3) = " +dim(mat3))

  } catch {
    case e: Exception => println(e); e.printStackTrace()
  }
/*
test output:
vec1 = [5.0 2.0 6.0]
mat1 =
[1.0 2.0 3.0]
[4.0 5.0 6.0]
[7.0 8.0 9.0]

mat2 =
[10.0 11.0 12.0]
[13.0 14.0 15.0]
[16.0 17.0 18.0]

dim(mat1) = (3,3)
trace(mat1) = 15.0
transpose(mat2) =
[10.0 13.0 16.0]
[11.0 14.0 17.0]
[12.0 15.0 18.0]

sum(mat1, mat2) =
[11.0 13.0 15.0]
[17.0 19.0 21.0]
[23.0 25.0 27.0]

product(mat1, vec1) = [27.0 66.0 105.0]
java.lang.Exception: Dimensions don't match
*/



