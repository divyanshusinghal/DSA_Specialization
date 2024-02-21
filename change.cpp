// Compute the minimum number of coins needed to change the given value into coins with denominations 1, 5, and 10.

#include <iostream>

int get_change(int m) {
  //write your code here

	int count_of_coins = 0;
	while (m > 0)
	{
		if (m >= 10)
		{
			count_of_coins += 1;
			m = m - 10;
		}
		else if (m >= 5)
		{
			count_of_coins += 1;
			m = m - 5;
		}
		else if (m >= 1)
		{
			count_of_coins += 1;
			m = m - 1;
		}
	}

  return count_of_coins;
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << '\n';

  return 0;
}
